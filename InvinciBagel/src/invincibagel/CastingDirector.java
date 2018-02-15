/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package invincibagel;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 *
 * @author mahedi
 */
public class CastingDirector {

    private final List<Actor> CURRENT_CAST;
    private final List<Actor> COLLIDE_CHECKLIST;
    private final Set<Actor> REMOVED_ACTORS;

    public CastingDirector() {
        this.REMOVED_ACTORS = new HashSet<>();
        this.COLLIDE_CHECKLIST = new ArrayList<>();
        this.CURRENT_CAST = new ArrayList<>();
    }

    public List<Actor> getCurrentCast() {
        return CURRENT_CAST;
    }

    public void addCurrentCast(Actor... actors) {
        if (actors.length > 1) {
            CURRENT_CAST.addAll(Arrays.asList(actors));
        } else {
            CURRENT_CAST.add(actors[0]);
        }
    }

    public void removeCurrentCast(Actor... actors) {
        CURRENT_CAST.removeAll(Arrays.asList(actors));
    }

    public void resetCurrentCast() {
        CURRENT_CAST.clear();
    }

    public List getCollideCheckList() {
        return COLLIDE_CHECKLIST;
    }

    public void resetCollideCheckList() {
        COLLIDE_CHECKLIST.clear();
        COLLIDE_CHECKLIST.addAll(CURRENT_CAST);
    }

    public Set getRemovedActors() {
        return REMOVED_ACTORS;
    }

    public void addToRemovedActors(Actor... actors) {
        if (actors.length > 1) {
            REMOVED_ACTORS.addAll(Arrays.asList((Actor[]) actors));
        } else {
            REMOVED_ACTORS.add(actors[0]);
        }
    }

    public void resetRemovedActors() {
        CURRENT_CAST.removeAll(REMOVED_ACTORS);
        REMOVED_ACTORS.clear();
    }
}
