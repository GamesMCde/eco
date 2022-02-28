package com.willfp.eco.core.requirement.impl;

import com.willfp.eco.core.Eco;
import com.willfp.eco.core.integrations.placeholder.PlaceholderManager;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import java.util.List;

/**
 * Moved to API in 6.26.0 after being marked for removal. This class should never be referenced, it
 * was moved back to the API in order to remove backend components related to Requirements.
 *
 * @deprecated No typing, weak definitions, and not an API component. Shouldn't be in eco.
 */
@SuppressWarnings("removal")
@Deprecated(since = "6.26.0", forRemoval = true)
public class RequirementPlaceholderLessThan extends com.willfp.eco.core.requirement.Requirement {
    @Override
    public boolean doesPlayerMeet(@NotNull final Player player,
                                  @NotNull final List<String> args) {
        if (args.size() < 2) {
            return false;
        }

        double actual;
        try {
            actual = Double.parseDouble(PlaceholderManager.translatePlaceholders(args.get(0), player));
        } catch (NumberFormatException e) {
            return false;
        }

        double expected;
        try {
            expected = Double.parseDouble(args.get(1));
        } catch (NumberFormatException e) {
            return false;
        }

        return actual < expected;
    }

    static {
        Eco.getHandler().getEcoPlugin().getLogger().severe("Loading for-removal Requirements system! This will throw an error once 6.27.0 is released."
                + "Make sure you're running the latest version of all your plugins!");
    }
}