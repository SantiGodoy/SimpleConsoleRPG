package com.projectdss;

import java.util.Set;
import com.projectdss.Ability;
import com.projectdss.CharacterStats;

/**
 * 
 */
public abstract class Character {

    protected final int id;
    protected final String name;
    protected int level;
    protected final CharacterStats characterStats;
    protected final Set<Ability> abilities;

    public Character(int id, String name, int level, CharacterStats characterStats, Set<Ability> abilities) {
        this.id = id;
        this.name = name;
        this.level = level;
        this.characterStats = characterStats;
        this.abilities = abilities;
    }

    public void addAbility(Ability ability) {
        abilities.add(ability);
    }

    public void removeAbility(Ability ability) {
        abilities.remove(ability);
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getLevel() {
        return level;
    }

    public CharacterStats getStats() {
        return characterStats;
    }

    public Set<Ability> getAbilities() {
        return abilities;
    }

    public boolean isAlive() {
        return characterStats.getCurrentHealth() > 0;
    }

    public Ability searchAbility(int abilityIndex) {
        int counter = 0;

        for(Ability ability : abilities) {
            ++counter;

            if(counter == abilityIndex)
                return ability;
        }

        return null;
    }

    public Ability searchAvailableAbility(int availableAbilityIndex) {
        int currentMana = characterStats.getCurrentMana(),
            counter = 0;

        for(Ability ability : abilities) {
            if(ability.getNecessaryMana() <= currentMana)
                ++counter;

            if(counter == availableAbilityIndex)
                return ability;
        }

        return null;
    }

    public abstract String getGender();

}