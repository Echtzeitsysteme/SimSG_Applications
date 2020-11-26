package util.generator;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.XMIResource;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;

import Voter.Voter1;
import Voter.Container;
import Voter.VoterFactory;


public class VoterGenerator {
	
	private VoterFactory factory = VoterFactory.eINSTANCE;
	private String outputPath;
	private Container model;
	

	private int numOfVoters;
	
	private List<Voter1> voters;
	
	public Container generate(String path) {
		model = factory.createContainer();
		outputPath = path;
		
		genVoters();
		model.getVoters().addAll(voters);
		
		saveToFile();
		
		return model;
	}
	
	public void setNumOfVoters(final int num) {
		this.numOfVoters = num;
	}
	
	private void genVoters() {
		voters = new LinkedList<>();
		for(int i = 0; i<numOfVoters; i++) {
			Voter1 voter = factory.createVoter1();
			if (i % 3 == 0) 
				{voter.setVote(false);} 
				{voter.setVote(true);};
			voters.add(voter);
		}
	}
	
	private void saveToFile() {
		URI uri = URI.createFileURI(outputPath);
		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put("xmi", new XMIResourceFactoryImpl());
		ResourceSet rs = new ResourceSetImpl();
		rs.getResourceFactoryRegistry().getExtensionToFactoryMap().put("xmi", new XMIResourceFactoryImpl());
		Resource modelResource = rs.createResource(uri);
		
		modelResource.getContents().add(model);
		
		Map<Object, Object> saveOptions = ((XMIResource)modelResource).getDefaultSaveOptions();
		saveOptions.put(XMIResource.OPTION_ENCODING,"UTF-8");
		saveOptions.put(XMIResource.OPTION_USE_XMI_TYPE, Boolean.TRUE);
		saveOptions.put(XMIResource.OPTION_SAVE_TYPE_INFORMATION,Boolean.TRUE);
		saveOptions.put(XMIResource.OPTION_SCHEMA_LOCATION_IMPLEMENTATION, Boolean.TRUE);
		
		try {
			((XMIResource)modelResource).save(saveOptions);
		} catch (IOException e) {
			e.printStackTrace();
		}
		modelResource.unload();
		
		System.out.println("Model saved to: "+uri.path());
	}

}