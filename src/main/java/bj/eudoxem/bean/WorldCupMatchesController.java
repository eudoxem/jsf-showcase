package bj.eudoxem.bean;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;

import bj.eudoxem.model.Match;

/**
 * Holds the football world cup matches results.
 * <p>
 * Stands as a model component in the MVC pattern.
 * 
 * @author emevi
 */
@ManagedBean
public class WorldCupMatchesController implements Serializable {

	/** Serial version UID. */
	private static final long serialVersionUID = 1L;

	/** The matches. */
	@ManagedProperty(value = "#{dataLoader.matches}")
	private List<Match> matches;

	/**
	 * Gets the matches.
	 *
	 * @return the matches
	 */
	public List<Match> getMatches() {

		return matches;
	}

	public WorldCupMatchesController() {
		super();
	}

	/**
	 * Sets the matches.
	 *
	 * @param matches
	 *            the new matches
	 */
	public void setMatches(List<Match> matches) {
		this.matches = matches;
	}

	/**
	 * Gets the results table.
	 *
	 * @return the results table
	 */
	public String viewResults() {
		return "success";
	}

	/**
	 * View home page.
	 *
	 * @return the string
	 */
	public String viewHomePage() {
		return "success";
	}
}
