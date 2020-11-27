package voterSim.rules.hipe.engine;

import org.eclipse.emf.common.notify.Notification;

import java.text.DecimalFormat;
import java.lang.Thread;
import java.time.Duration;
import java.util.Set;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutionException;
import java.util.stream.Collectors;

import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.actor.Props;
import static akka.pattern.Patterns.ask;

import voterSim.rules.hipe.engine.actor.NotificationActor;
import voterSim.rules.hipe.engine.actor.DispatchActor;
import voterSim.rules.hipe.engine.actor.edge.Voter1_link_0_reference;
import voterSim.rules.hipe.engine.actor.junction.newVoterFalse_28_junction;
import voterSim.rules.hipe.engine.actor.junction.newVoterFalse_26_junction;
import voterSim.rules.hipe.engine.actor.junction.newVoterTrue_33_junction;
import voterSim.rules.hipe.engine.actor.junction.newVoterTrue_31_junction;
import voterSim.rules.hipe.engine.actor.junction.switchRandom_37_junction;
import voterSim.rules.hipe.engine.actor.node.Voter1_object_SP0;
import voterSim.rules.hipe.engine.actor.node.Voter1_object_SP1;

import hipe.engine.IHiPEEngine;
import hipe.engine.message.InitActor;
import hipe.engine.message.InitGenActor;
import hipe.engine.message.InitGenReferenceActor;
import hipe.engine.message.NoMoreInput;
import hipe.engine.message.NotificationMessage;
import hipe.engine.message.ExtractData;
import hipe.engine.message.production.ProductionResult;

import hipe.engine.util.IncUtil;
import hipe.engine.util.ProductionUtil;
import hipe.generic.actor.GenericObjectActor;
import hipe.generic.actor.GenericReferenceActor;
import hipe.generic.actor.GenericProductionActor;
import hipe.generic.actor.junction.*;
import hipe.generic.actor.junction.util.HiPEConfig;

import hipe.network.*;

public class HiPEEngine implements IHiPEEngine{

	private final ActorSystem system = ActorSystem.create("HiPE-Engine");
	private ActorRef dispatcher;
	private ActorRef notificationActor;

	private Map<String, NetworkNode> name2node = new HashMap<>();
	
	private Map<String, ActorRef> name2actor = new ConcurrentHashMap<>();
	private Map<String, InitGenReferenceActor<?,?>> name2initRefGen = new ConcurrentHashMap<>();
	private Map<String, Class<?>> classes = new ConcurrentHashMap<>();
	private Map<String, String> productionNodes2pattern = new ConcurrentHashMap<>();
	private boolean dirty = false;
	private HiPENetwork network;
	
	final private IncUtil incUtil = new IncUtil();
	final private ProductionUtil prodUtil = new ProductionUtil();
	
	private long time = 0;
	private int counter = 0;
	
	private Thread thread;
	
	public HiPEEngine(HiPENetwork network) {
		thread = Thread.currentThread();
		incUtil.registerWakeUpCall(this::wakeUp);
		
		this.network = network;
	}
	
	public boolean wakeUp() {
		thread.interrupt();
		return true;
	}
	
	public void initialize() throws InterruptedException {
		network.getNetworknode().stream().forEach(n -> name2node.put(n.getName(), n));
		
		createProductionNodes();
		createJunctionNodes();
		createReferenceNodes();
		createObjectNodes();

		initializeReferenceNodes();

		classes.keySet().parallelStream().forEach(name -> {
			name2actor.put(name, system.actorOf(Props.create(classes.get(name))));			
		});
		
		dispatcher = system.actorOf(
				Props.create(DispatchActor.class, () -> new DispatchActor(name2actor, incUtil)),
				"DispatchActor");
		
		notificationActor = system.actorOf(Props.create(NotificationActor.class, () -> new NotificationActor(dispatcher, incUtil)), "NotificationActor");
		
		name2actor.values().forEach(actor -> actor.tell(new InitActor(name2actor), notificationActor));
		network.getNetworknode().stream().filter(n -> n instanceof ObjectNode).forEach(n -> name2actor.get(n.getName()).tell(new InitGenActor(name2actor, n, prodUtil, incUtil), notificationActor));
		network.getNetworknode().stream().filter(n -> n instanceof ReferenceNode).forEach(n -> name2actor.get(n.getName()).tell(name2initRefGen.get(n.getName()), notificationActor));
		network.getNetworknode().stream().filter(n -> n instanceof AbstractJunctionNode).forEach(n -> name2actor.get(n.getName()).tell(new InitGenActor(name2actor, n, prodUtil, incUtil), notificationActor));
		network.getNetworknode().stream().filter(n -> n instanceof ProductionNode).forEach(n -> name2actor.get(n.getName()).tell(new InitGenActor(name2actor, n, prodUtil, incUtil), notificationActor));
		}
	
	public void createProductionNodes() {
		classes.put("agreeFalse_production", GenericProductionActor.class);
		productionNodes2pattern.put("agreeFalse_production", "agreeFalse");
		classes.put("agreeTrue_production", GenericProductionActor.class);
		productionNodes2pattern.put("agreeTrue_production", "agreeTrue");
		classes.put("connectedV1V3_production", GenericProductionActor.class);
		productionNodes2pattern.put("connectedV1V3_production", "connectedV1V3");
		classes.put("convert_production", GenericProductionActor.class);
		productionNodes2pattern.put("convert_production", "convert");
		classes.put("disagree_production", GenericProductionActor.class);
		productionNodes2pattern.put("disagree_production", "disagree");
		classes.put("newVoterFalse_production", GenericProductionActor.class);
		productionNodes2pattern.put("newVoterFalse_production", "newVoterFalse");
		classes.put("newVoterTrue_production", GenericProductionActor.class);
		productionNodes2pattern.put("newVoterTrue_production", "newVoterTrue");
		classes.put("switchRandom_production", GenericProductionActor.class);
		productionNodes2pattern.put("switchRandom_production", "switchRandom");
		classes.put("voteFalse_production", GenericProductionActor.class);
		productionNodes2pattern.put("voteFalse_production", "voteFalse");
		classes.put("voteTrue_production", GenericProductionActor.class);
		productionNodes2pattern.put("voteTrue_production", "voteTrue");
		
	}
	
	public void createJunctionNodes() {
		classes.put("agreeFalse_1_junction", GenericJunctionActor.class);
		classes.put("agreeTrue_6_junction", GenericJunctionActor.class);
		classes.put("connectedV1V3_11_junction", GenericJunctionActor.class);
		classes.put("convert_16_junction", GenericJunctionActor.class);
		classes.put("disagree_21_junction", GenericJunctionActor.class);
		classes.put("newVoterFalse_28_junction", newVoterFalse_28_junction.class);
		classes.put("newVoterFalse_26_junction", newVoterFalse_26_junction.class);
		classes.put("newVoterTrue_33_junction", newVoterTrue_33_junction.class);
		classes.put("newVoterTrue_31_junction", newVoterTrue_31_junction.class);
		classes.put("switchRandom_39_junction", GenericJunctionActor.class);
		classes.put("switchRandom_37_junction", switchRandom_37_junction.class);
		classes.put("switchRandom_36_nacjunction", GenericNACJunctionActor.class);
	}
	
	public void createReferenceNodes() {
		classes.put("Voter1_link_0_reference",Voter1_link_0_reference.class);
		
	}
	
	public void createObjectNodes() {
		classes.put("Voter1_object_SP0",Voter1_object_SP0.class);
		classes.put("Voter1_object_SP1",Voter1_object_SP1.class);
		classes.put("Voter1_object_SP2",Voter1_object_SP2.class);
		
	}
	
	public void initializeReferenceNodes() {
		name2initRefGen.put("Voter1_link_0_reference", new InitGenReferenceActor<Voter.Voter1,Voter.Voter1>(name2actor, name2node.get("Voter1_link_0_reference"), (o) -> o instanceof Voter.Voter1, null, (o) -> o.getLink(), true, prodUtil, incUtil));
	}
	
	/**
	 * delegate notifications to dispatcher actor
	 * @param notification
	 */			
	public void handleNotification(Notification notification) {
		try {
			dirty = true;
			ask(notificationActor, new NotificationMessage(notification), Duration.ofHours(24)).toCompletableFuture().get();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (ExecutionException e) {
			e.printStackTrace();
		}			
	}
	
	public Map<String, ProductionResult> extractData() throws InterruptedException {
		if(!dirty) {
			return java.util.Collections.synchronizedMap(new HashMap<>());
		}	
		
		long tic = System.nanoTime();
		counter++;
		
		dirty = false;
		
		notificationActor.tell(new NoMoreInput(), notificationActor);
		
		try {
			Thread.sleep(100000000);
		} catch(Exception e) {
		}
		
		Map<String, ProductionResult> productionResults = prodUtil.getProductionResults();
				
		incUtil.clean();
		prodUtil.clean();
		
		time += System.nanoTime() - tic;
		
		return productionResults;
	}
	
	public void terminate() {
		if(HiPEConfig.logWorkloadActivated) {
			DecimalFormat df = new DecimalFormat("0.#####");
	        df.setMaximumFractionDigits(5);
			System.err.println("HiPEEngine" + ";"  + counter + ";" + df.format((double) time / (double) (1000 * 1000 * 1000)));
		}
						
		system.terminate();	
	}
	
}

class Voter1_object_SP2 extends GenericObjectActor<Voter.Voter1> { }


