package edu.ucsb.cs156.spring.hello;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TeamTest {

    Team team;

    @BeforeEach
    public void setup() {
        team = new Team("test-team");    
    }

    @Test
    public void getName_returns_correct_name() {
       assert(team.getName().equals("test-team"));
    }

   
    // TODO: Add additional tests as needed to get to 100% jacoco line coverage, and
    // 100% mutation coverage (all mutants timed out or killed)
    @Test
    public void toString_returns_correct_string() {
        assertEquals("Team(name=test-team, members=[])", team.toString());
    }

    @Test 
    public void equals_returns_true_for_same_object() {
        assert(team.equals(team));
    }

    @Test
    public void equals_returns_false_for_different_object() {
        String str = "test";
        assert(!team.equals(str));
    }

    @Test
    public void equals_returns_true_for_same_team() {
        team.addMember("Jeremiah W.");
        team.addMember("Ethan S.");

        Team team2 = new Team("test-team");
        team2.addMember("Jeremiah W.");
        team2.addMember("Ethan S.");
        assert(team.equals(team2));
    }

    @Test
    public void equals_returns_false_for_different_team_members() {
        team.addMember("Jeremiah W.");
        team.addMember("Ethan S.");

        Team team2 = new Team("test-team");
        team2.addMember("Jeremiah W.");
        team2.addMember("Ethan S.");
        team2.addMember("C");
        assert(!team.equals(team2));
    }

    @Test
    public void equals_returns_false_for_different_team_name() {
        team.addMember("Jeremiah W.");
        team.addMember("Ethan S.");

        Team team2 = new Team("test-team-2");
        team2.addMember("Jeremiah W.");
        team2.addMember("Ethan S.");
        assert(!team.equals(team2));
    }

    @Test
    public void hashCode_returns_same_hashcode_for_equal_teams() {
        Team t = new Team("test-team");
        int result = t.hashCode();
        int expectedResult = -1226298695;
        // System.out.println("Hashcode: " + result);
        assertEquals(expectedResult, result);
    }
}
