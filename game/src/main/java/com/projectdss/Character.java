package com.projectdss;

import java.util.Set;
import com.projectdss.Ability;
import com.projectdss.CharacterStats;

/**
 * 
 */
public abstract class Character {

    protected String name;
    protected int level;
    protected CharacterStats characterStats;
    protected Set<Ability> abilities;

    public Character() {}

    public Character(String name, int level, CharacterStats characterStats, Set<Ability> abilities) {
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public CharacterStats getCharacterStats() {
        return characterStats;
    }

    public void setCharacterStats(CharacterStats characterStats) {
        this.characterStats = characterStats;
    }

    public Set<Ability> getAbilities() {
        return abilities;
    }

    public void setAbilities(Set<Ability> abilities) {
        this.abilities = abilities;
    }

    public boolean isAlive() {
        return characterStats.getCurrentHealth() > 0;
    }

    public abstract String getGender();

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
}