package bj.eudoxem.model;

import java.util.Date;

public class Match {

	private Team home;
	
	private Team away;
	
	private String stage;
	
	private String result;
	
	private Date date;
	
	private String stadium;

	public Match(Team home, Team away) {
		super();
		this.home = home;
		this.away = away;
	}
	
	public Team getHome() {
		return home;
	}

	public void setHome(Team home) {
		this.home = home;
	}

	public Team getAway() {
		return away;
	}

	public void setAway(Team away) {
		this.away = away;
	}

	public String getStage() {
		return stage;
	}

	public void setStage(String stage) {
		this.stage = stage;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getStadium() {
		return stadium;
	}

	public void setStadium(String stadium) {
		this.stadium = stadium;
	}


	
}
