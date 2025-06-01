package edu.sdccd.cisc191.Common;

import lombok.Data;

/**
 * Data Transfer Object (DTO) representing an incoming bet.
 */
@Data
public class IncomingBetDTO {

    /**
     * The ID of the game that the bet is placed on.
     */
    private Long gameId;

    /**
     * The name or identifier of the team that the user is betting on.
     */
    private String betTeam;

    /**
     * The amount of money the user is betting.
     */
    private int betAmt;

    /**
     * The potential amount the user can win if the bet is successful.
     */
    private int winAmt;

    /**
     * Constructs a new {@code IncomingBetDTO} with the specified values.
     */
    public IncomingBetDTO(Long gameId, String betTeam, int betAmt, int winAmt) {
        this.gameId = gameId;
        this.betTeam = betTeam;
        this.betAmt = betAmt;
        this.winAmt = winAmt;
        // TODO: Make sure values like betAmt and winAmt aren't negative
    }

    // TODO: Add default constructor if some tools or libraries need it
}
