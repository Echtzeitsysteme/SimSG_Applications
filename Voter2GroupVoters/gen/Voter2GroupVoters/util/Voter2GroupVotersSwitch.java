/**
 */
package Voter2GroupVoters.util;

import Voter2GroupVoters.*;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.util.Switch;

import runtime.TGGRuleApplication;

/**
 * <!-- begin-user-doc -->
 * The <b>Switch</b> for the model's inheritance hierarchy.
 * It supports the call {@link #doSwitch(EObject) doSwitch(object)}
 * to invoke the <code>caseXXX</code> method for each class of the model,
 * starting with the actual class of the object
 * and proceeding up the inheritance hierarchy
 * until a non-null result is returned,
 * which is the result of the switch.
 * <!-- end-user-doc -->
 * @see Voter2GroupVoters.Voter2GroupVotersPackage
 * @generated
 */
public class Voter2GroupVotersSwitch<T> extends Switch<T> {
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static Voter2GroupVotersPackage modelPackage;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Voter2GroupVotersSwitch() {
		if (modelPackage == null) {
			modelPackage = Voter2GroupVotersPackage.eINSTANCE;
		}
	}

	/**
	 * Checks whether this is a switch for the given package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param ePackage the package in question.
	 * @return whether this is a switch for the given package.
	 * @generated
	 */
	@Override
	protected boolean isSwitchFor(EPackage ePackage) {
		return ePackage == modelPackage;
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	@Override
	protected T doSwitch(int classifierID, EObject theEObject) {
		switch (classifierID) {
			case Voter2GroupVotersPackage.CONTAINER2_GROUP_VOTERS_CONTAINER: {
				Container2GroupVotersContainer container2GroupVotersContainer = (Container2GroupVotersContainer)theEObject;
				T result = caseContainer2GroupVotersContainer(container2GroupVotersContainer);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case Voter2GroupVotersPackage.VOTER2_GROUP_VOTER: {
				Voter2GroupVoter voter2GroupVoter = (Voter2GroupVoter)theEObject;
				T result = caseVoter2GroupVoter(voter2GroupVoter);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case Voter2GroupVotersPackage.VOTER2_GROUP: {
				Voter2Group voter2Group = (Voter2Group)theEObject;
				T result = caseVoter2Group(voter2Group);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case Voter2GroupVotersPackage.CONTAINER2_GROUP_VOTERS_CONTAINER_MARKER: {
				Container2GroupVotersContainer__Marker container2GroupVotersContainer__Marker = (Container2GroupVotersContainer__Marker)theEObject;
				T result = caseContainer2GroupVotersContainer__Marker(container2GroupVotersContainer__Marker);
				if (result == null) result = caseTGGRuleApplication(container2GroupVotersContainer__Marker);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case Voter2GroupVotersPackage.VOTER2_GROUP_MARKER: {
				Voter2Group__Marker voter2Group__Marker = (Voter2Group__Marker)theEObject;
				T result = caseVoter2Group__Marker(voter2Group__Marker);
				if (result == null) result = caseTGGRuleApplication(voter2Group__Marker);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case Voter2GroupVotersPackage.VOTER2_GROUP_VOTER_MARKER: {
				Voter2GroupVoter__Marker voter2GroupVoter__Marker = (Voter2GroupVoter__Marker)theEObject;
				T result = caseVoter2GroupVoter__Marker(voter2GroupVoter__Marker);
				if (result == null) result = caseTGGRuleApplication(voter2GroupVoter__Marker);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case Voter2GroupVotersPackage.VOTER_RELATION2_VOTER_GROUP_RELATION_MARKER: {
				VoterRelation2VoterGroupRelation__Marker voterRelation2VoterGroupRelation__Marker = (VoterRelation2VoterGroupRelation__Marker)theEObject;
				T result = caseVoterRelation2VoterGroupRelation__Marker(voterRelation2VoterGroupRelation__Marker);
				if (result == null) result = caseTGGRuleApplication(voterRelation2VoterGroupRelation__Marker);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			default: return defaultCase(theEObject);
		}
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Container2 Group Voters Container</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Container2 Group Voters Container</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseContainer2GroupVotersContainer(Container2GroupVotersContainer object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Voter2 Group Voter</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Voter2 Group Voter</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseVoter2GroupVoter(Voter2GroupVoter object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Voter2 Group</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Voter2 Group</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseVoter2Group(Voter2Group object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Container2 Group Voters Container Marker</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Container2 Group Voters Container Marker</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseContainer2GroupVotersContainer__Marker(Container2GroupVotersContainer__Marker object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Voter2 Group Marker</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Voter2 Group Marker</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseVoter2Group__Marker(Voter2Group__Marker object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Voter2 Group Voter Marker</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Voter2 Group Voter Marker</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseVoter2GroupVoter__Marker(Voter2GroupVoter__Marker object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Voter Relation2 Voter Group Relation Marker</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Voter Relation2 Voter Group Relation Marker</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseVoterRelation2VoterGroupRelation__Marker(VoterRelation2VoterGroupRelation__Marker object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>TGG Rule Application</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>TGG Rule Application</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTGGRuleApplication(TGGRuleApplication object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch, but this is the last case anyway.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject)
	 * @generated
	 */
	@Override
	public T defaultCase(EObject object) {
		return null;
	}

} //Voter2GroupVotersSwitch
