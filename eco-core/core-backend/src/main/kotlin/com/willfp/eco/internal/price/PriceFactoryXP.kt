package com.willfp.eco.internal.price

import com.willfp.eco.core.price.Price
import com.willfp.eco.core.price.PriceFactory
import org.bukkit.entity.Player
import java.util.function.Supplier
import kotlin.math.roundToInt

object PriceFactoryXP : PriceFactory {
    override fun getNames() = listOf(
        "xp",
        "exp",
        "experience"
    )

    override fun create(function: Supplier<Double>): Price {
        return PriceXP { function.get().roundToInt() }
    }

    private class PriceXP(
        private val xp: () -> Int
    ) : Price {
        override fun canAfford(player: Player) = player.totalExperience >= xp()

        override fun pay(player: Player) {
            player.totalExperience -= xp()
        }

        override fun giveTo(player: Player) {
            player.totalExperience += xp()
        }
    }
}
