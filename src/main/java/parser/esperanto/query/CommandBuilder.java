/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parser.esperanto.query;

import static java.lang.String.join;
import java.util.ArrayList;
import java.util.List;
import jpl.Query;
import org.apache.commons.lang3.StringUtils;
import static org.apache.commons.lang3.StringUtils.removePattern;

/**
 *
 * @author Timi
 */
public class CommandBuilder {

    private static final String PATTERN = "[^a-z ĉĝĥĵŝŭ]";

    public static final String PREDICATE = "word";
    public static final String TERM1 = "Word";
    public static final String TERM2 = "PartOfSpeech";

    public static String buildCommand(String sentence) {
        sentence = sentence.replaceAll(" +", " ");
        if (sentence.startsWith(" ")) {
            sentence = sentence.substring(1);
        }
        sentence = removePattern(sentence.toLowerCase(), PATTERN);
        String[] words = sentence.split(" ");
        String command = "sentence([" + join(", ", words) + "], []).";
        return command;
    }

    public static String getQuery() {
        return PREDICATE + "(" + TERM1 + ", " + TERM2 + ").";
    }

    public static String getResult(String text) throws Exception {
        Query setSentence = new Query(buildCommand(text));
        if (!setSentence.query()) {
            throw new Exception("Hibás mondat");
        }

        Query query = new Query(getQuery());
        if (!query.hasSolution()) {
            throw new Exception("Hibás adat");
        }
        
        String word, partOfSpeech;
        List<String> rows = new ArrayList<>();
        
        while (query.hasMoreSolutions()) {
            word = query.nextSolution().get(CommandBuilder.TERM1).toString();
            partOfSpeech = StringUtils.remove(query.nextSolution().get(CommandBuilder.TERM2).toString(), "'");
            rows.add(word + "\t" + partOfSpeech );
        }
        
        return join("\n", rows);
    }
}
