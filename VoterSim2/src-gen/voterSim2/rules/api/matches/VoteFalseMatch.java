package voterSim2.rules.api.matches;

import org.emoflon.ibex.common.operational.IMatch;
import org.emoflon.ibex.gt.api.GraphTransformationMatch;
import Voter.Voter1;
import voterSim2.rules.api.rules.VoteFalsePattern;

/**
 * A match for the pattern <code>voteFalse()</code>.
 */
public class VoteFalseMatch extends GraphTransformationMatch<VoteFalseMatch, VoteFalsePattern> {
	private Voter1 varV;

	/**
	 * Creates a new match for the pattern <code>voteFalse()</code>.
	 * 
	 * @param pattern
	 *            the pattern
	 * @param match
	 *            the untyped match
	 */
	public VoteFalseMatch(final VoteFalsePattern pattern, final IMatch match) {
		super(pattern, match);
		varV = (Voter1) match.get("v");
	}

	/**
	 * Returns the v.
	 *
	 * @return the v
	 */
	public Voter1 getV() {
		return varV;
	}

	@Override
	public String toString() {
		String s = "match {" + System.lineSeparator();
		s += "	v --> " + varV + System.lineSeparator();
		s += "} for " + getPattern();
		return s;
	}
}
