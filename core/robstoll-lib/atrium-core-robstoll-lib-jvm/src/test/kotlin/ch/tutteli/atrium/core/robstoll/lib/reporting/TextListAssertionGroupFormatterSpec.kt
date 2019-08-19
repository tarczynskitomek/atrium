package ch.tutteli.atrium.core.robstoll.lib.reporting

import ch.tutteli.atrium.assertions.BulletPointIdentifier
import ch.tutteli.atrium.assertions.DefaultListAssertionGroupType
import ch.tutteli.atrium.assertions.ListAssertionGroupType
import ch.tutteli.atrium.api.verbs.internal.AssertionVerbFactory
import ch.tutteli.atrium.reporting.AssertionFormatterController
import ch.tutteli.atrium.reporting.ObjectFormatter
import ch.tutteli.atrium.reporting.translating.Translator
import org.jetbrains.spek.api.Spek
import org.jetbrains.spek.api.include
import kotlin.reflect.KClass

//TODO #116 migrate spek1 to spek2 - move to common module
class TextListAssertionGroupFormatterSpec : Spek({

    include(AtriumsTextListAssertionFormatterSpec)
    include(AtriumsSingleAssertionGroupTypeFormatterSpec)
    include(AtriumsAssertionFormatterSpec)

}) {
    object AtriumsTextListAssertionFormatterSpec : ch.tutteli.atrium.specs.reporting.TextListAssertionGroupFormatterSpec(
        AssertionVerbFactory,
        factoryWithBullet(), "[Atrium's TextList...Spec] ")

    object AtriumsSingleAssertionGroupTypeFormatterSpec : ch.tutteli.atrium.specs.reporting.SingleAssertionGroupTypeFormatterSpec<ListAssertionGroupType>(
        AssertionVerbFactory,
        factoryWithBullet(),
        ListAssertionGroupType::class,
        object : ListAssertionGroupType {},
        DefaultListAssertionGroupType,
        "[Atrium's SingleAssertionGroupType...Spec] "
    )

    object AtriumsAssertionFormatterSpec : ch.tutteli.atrium.specs.reporting.AssertionFormatterSpec(
        AssertionVerbFactory,
        factoryWithBullet(), "[Atrium's AssertionFormatterSpec] "
    )

    companion object {
        internal fun factoryWithBullet() = { bulletPoints: Map<KClass<out BulletPointIdentifier>, String>, assertionFormatterController: AssertionFormatterController, objectFormatter: ObjectFormatter, translator: Translator ->
            TextListAssertionGroupFormatter(
                bulletPoints,
                assertionFormatterController,
                TextSameLineAssertionPairFormatter(
                    objectFormatter,
                    translator
                )
            )
        }
    }
}
