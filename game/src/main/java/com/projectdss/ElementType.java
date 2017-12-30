package com.projectdss;

import java.util.*;

/**
 * @author JoseCorrero
 *
 * Enumerate ElementType.
 */
public enum ElementType {
    BASIC,
    FIRE,
    AIR,
    ELECTRIC,
    WATER;

    public static final double[][] elementalMatrix = {{1,    1,    1,    1,    1},
                                                      {1, 0.75,    2,    1,  0.5},
                                                      {1,  0.5, 0.75,    2,    1},
                                                      {1,    1,  0.5, 0.75,    2},
                                                      {1,    2,    1,  0.5, 0.75}};

    @override
    public String toString() {
        switch(this) {
            case BASIC:     return "Basic";
            case FIRE:      return "Fire";
            case AIR:       return "Air";
            case ELECTRIC:  return "Electric";
            case WATER:     return "Water";
            case default:   return "";
        }
    }
}