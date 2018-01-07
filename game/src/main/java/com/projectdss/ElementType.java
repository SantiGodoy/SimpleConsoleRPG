package com.projectdss;

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

    public static final double[][] ELEMENT_DAMAGE = {{1,    1,    1,    1,    1},
                                                      {1, 0.75,    2,    1,  0.5},
                                                      {1,  0.5, 0.75,    2,    1},
                                                      {1,    1,  0.5, 0.75,    2},
                                                      {1,    2,    1,  0.5, 0.75}};

    public static double getElementDamage(ElementType type1, ElementType type2) {
        return ELEMENT_DAMAGE[type1.ordinal()][type2.ordinal()];
    }

    @Override
    public String toString() {
        switch(this) {
            case BASIC:     return "Basic";
            case FIRE:      return "Fire";
            case AIR:       return "Air";
            case ELECTRIC:  return "Electric";
            case WATER:     return "Water";
            default:   return "";
        }
    }
}