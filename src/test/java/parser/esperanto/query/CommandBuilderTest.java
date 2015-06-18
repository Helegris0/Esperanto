/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parser.esperanto.query;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Timi
 */
public class CommandBuilderTest {

    public CommandBuilderTest() {
    }

    @Test
    public void testBuiltCommand() {
        assertEquals("sentence([la, birdo, kantas, belan, kanton], []).", CommandBuilder.buildCommand("La birdo kantas belan kanton."));
        assertEquals("sentence([junaj, virinoj, kuiras, la, bongustan, kukon], []).", CommandBuilder.buildCommand("junaj virinoj... kuiras la BONGUSTAN kukon!!"));
    }

    @Test
    public void testQueryString() {
        assertEquals("word(Word, PartOfSpeech).", CommandBuilder.getQuery());
    }
}
