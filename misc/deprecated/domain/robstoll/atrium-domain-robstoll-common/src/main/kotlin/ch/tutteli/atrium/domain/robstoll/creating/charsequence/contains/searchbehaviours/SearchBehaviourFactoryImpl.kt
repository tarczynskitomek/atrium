//TODO remove with 1.0.0
@file:Suppress("DEPRECATION")

package ch.tutteli.atrium.domain.robstoll.creating.charsequence.contains.searchbehaviours

import ch.tutteli.atrium.domain.creating.charsequence.contains.CharSequenceContains
import ch.tutteli.atrium.domain.creating.charsequence.contains.searchbehaviours.IgnoringCaseSearchBehaviour
import ch.tutteli.atrium.domain.creating.charsequence.contains.searchbehaviours.NoOpSearchBehaviour
import ch.tutteli.atrium.domain.creating.charsequence.contains.searchbehaviours.SearchBehaviourFactory
import ch.tutteli.atrium.domain.robstoll.lib.creating.charsequence.contains.searchbehaviours._containsIgnoringCase

@Deprecated("use extension function of atrium-logic; will be removed with 1.0.0")
class SearchBehaviourFactoryImpl : SearchBehaviourFactory {

    override fun <T : CharSequence> ignoringCase(
        containsBuilder: CharSequenceContains.Builder<T, NoOpSearchBehaviour>
    ): CharSequenceContains.Builder<T, IgnoringCaseSearchBehaviour> = _containsIgnoringCase(containsBuilder)
}
