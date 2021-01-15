package voterSim2.rules.hipe.engine.actor.edge;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;
import java.util.function.Consumer;

import hipe.engine.util.HiPESet;
import hipe.engine.actor.Port;
import hipe.engine.match.EdgeMatch;
import hipe.engine.message.NoMoreInput;
import hipe.engine.message.NewInput;
import hipe.engine.actor.edge.PortEdge;
import hipe.engine.actor.edge.PortEdgeLeft;
import hipe.engine.actor.edge.PortEdgeRight;

import hipe.network.ReferenceNode;

import hipe.generic.actor.GenericReferenceActor;

import akka.actor.AbstractActor;
import akka.actor.ActorRef;

public class Voter1_link_4_reference extends GenericReferenceActor<Voter.Voter1,Voter.Voter1> {

	@Override
	protected void initializePorts(Map<String, ActorRef> name2actor, ReferenceNode node) {
		ports = new LinkedList<>();
		ports.add(new PortEdgeLeft(node.getPorts().getPort().get(0), getSelf(), name2actor.get("connectedV1V3_11_junction"), this::check_constraint_9 , 0   ));
		ports.add(new PortEdgeRight(node.getPorts().getPort().get(1), getSelf(), name2actor.get("connectedV1V3_11_junction"), this::check_constraint_10 , 1   ));
		ports.add(new PortEdgeLeft(node.getPorts().getPort().get(2), getSelf(), name2actor.get("convert_16_junction"), this::check_constraint_11 , 2   ));
		ports.add(new PortEdgeRight(node.getPorts().getPort().get(3), getSelf(), name2actor.get("convert_16_junction"), this::check_constraint_12 , 3   ));
		ports.add(new PortEdgeLeft(node.getPorts().getPort().get(4), getSelf(), name2actor.get("disagree_21_junction"), this::check_constraint_13 , 4   ));
		ports.add(new PortEdgeRight(node.getPorts().getPort().get(5), getSelf(), name2actor.get("disagree_21_junction"), this::check_constraint_14 , 5   ));
		ports.add(new PortEdgeLeft(node.getPorts().getPort().get(6), getSelf(), name2actor.get("switchSame_29_junction"), this::check_constraint_15 , 6   ));
		ports.add(new PortEdgeRight(node.getPorts().getPort().get(7), getSelf(), name2actor.get("switchSame_29_junction"), this::check_constraint_16 , 7   ));
	}	

	public boolean check_constraint_9(EdgeMatch edge, int index) {
		Voter.Voter1 v1 = (Voter.Voter1) edge.source();
		Voter.Voter1 v3 = (Voter.Voter1) edge.target();
		boolean predicate = !v1.equals(v3);
		edge.setConstraintSatisfied(index, predicate);
		return predicate;
	}
	
	public boolean check_constraint_10(EdgeMatch edge, int index) {
		Voter.Voter1 v3 = (Voter.Voter1) edge.source();
		Voter.Voter1 v1 = (Voter.Voter1) edge.target();
		boolean predicate = !v1.equals(v3);
		edge.setConstraintSatisfied(index, predicate);
		return predicate;
	}
	
	public boolean check_constraint_11(EdgeMatch edge, int index) {
		Voter.Voter1 v1 = (Voter.Voter1) edge.source();
		Voter.Voter1 v2 = (Voter.Voter1) edge.target();
		boolean predicate = !v1.equals(v2) && v1.isVote()!=v2.isVote();
		edge.setConstraintSatisfied(index, predicate);
		return predicate;
	}
	
	public boolean check_constraint_12(EdgeMatch edge, int index) {
		Voter.Voter1 v2 = (Voter.Voter1) edge.source();
		Voter.Voter1 v1 = (Voter.Voter1) edge.target();
		boolean predicate = !v1.equals(v2) && v1.isVote()!=v2.isVote();
		edge.setConstraintSatisfied(index, predicate);
		return predicate;
	}
	
	public boolean check_constraint_13(EdgeMatch edge, int index) {
		Voter.Voter1 v1 = (Voter.Voter1) edge.source();
		Voter.Voter1 v2 = (Voter.Voter1) edge.target();
		boolean predicate = !v1.equals(v2) && v1.isVote()!=v2.isVote();
		edge.setConstraintSatisfied(index, predicate);
		return predicate;
	}
	
	public boolean check_constraint_14(EdgeMatch edge, int index) {
		Voter.Voter1 v2 = (Voter.Voter1) edge.source();
		Voter.Voter1 v1 = (Voter.Voter1) edge.target();
		boolean predicate = !v1.equals(v2) && v1.isVote()!=v2.isVote();
		edge.setConstraintSatisfied(index, predicate);
		return predicate;
	}
	
	public boolean check_constraint_15(EdgeMatch edge, int index) {
		Voter.Voter1 v1 = (Voter.Voter1) edge.source();
		Voter.Voter1 v2 = (Voter.Voter1) edge.target();
		boolean predicate = !v1.equals(v2) && v1.isVote()!=v2.isVote();
		edge.setConstraintSatisfied(index, predicate);
		return predicate;
	}
	
	public boolean check_constraint_16(EdgeMatch edge, int index) {
		Voter.Voter1 v2 = (Voter.Voter1) edge.source();
		Voter.Voter1 v1 = (Voter.Voter1) edge.target();
		boolean predicate = !v1.equals(v2) && v1.isVote()!=v2.isVote();
		edge.setConstraintSatisfied(index, predicate);
		return predicate;
	}
	
}

