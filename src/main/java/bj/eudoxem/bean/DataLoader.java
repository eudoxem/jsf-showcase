package bj.eudoxem.bean;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

import au.com.bytecode.opencsv.CSVReader;
import bj.eudoxem.model.Match;
import bj.eudoxem.model.Team;

// TODO: Auto-generated Javadoc
/**
 * Inits the football matches results from a file.
 * 
 * @author emevi
 *
 */
@ManagedBean
@ApplicationScoped
public class DataLoader {

	/** The matches. */
	private List<Match> matches = new ArrayList<Match>();

	/** The format. */
	private DateFormat format = new SimpleDateFormat("dd/MM/yyyy HH:mm");

	/**
	 * Gets the matches.
	 *
	 * @return the matches
	 */
	public List<Match> getMatches() {
		return matches;
	}

	/**
	 * Load file.
	 */
	@PostConstruct
	private void loadFile() {
		File file = new File(getClass().getResource(
				"/fifa_world_cup_2014_table.csv").getFile());
		FileReader fr = null;
		CSVReader csvReader = null;

		try {
			fr = new FileReader(file);
			csvReader = new CSVReader(fr, ';');

			String[] nextLine = null;
			while ((nextLine = csvReader.readNext()) != null) {

				if (nextLine.length == 0 || nextLine[0].equals("")
						|| nextLine[0].startsWith("#")) {
					continue;
				}

				matches.add(createMatch(nextLine));
			}
		} catch (IOException | ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (fr != null) {
				try {
					fr.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

			if (csvReader != null) {
				try {
					csvReader.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}

	/**
	 * Creates the match.
	 *
	 * @param nextLine
	 *            the next line
	 * @return the match
	 * @throws ParseException
	 *             the parse exception
	 */
	private Match createMatch(String[] nextLine) throws ParseException {
		String[] teams = nextLine[3].split("vs");
		Team home = new Team(teams[0].trim());
		Team away = new Team(teams[1].trim());

		Match match = new Match(home, away);
		match.setStage(nextLine[2]);
		match.setResult(nextLine[4]);
		match.setStadium(nextLine[5]);
		match.setDate(format.parse(nextLine[0] + " " + nextLine[1]));
		return match;
	}
}
