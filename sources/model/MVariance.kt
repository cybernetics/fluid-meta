package io.fluidsonic.meta

import kotlinx.metadata.*


enum class MVariance {

	INVARIANT,
	IN,
	OUT;


	override fun toString() =
		MetaCodeWriter.write(this)


	companion object
}


@Suppress("FunctionName")
internal fun MVariance(variance: KmVariance) =
	when (variance) {
		KmVariance.INVARIANT -> MVariance.INVARIANT
		KmVariance.IN -> MVariance.IN
		KmVariance.OUT -> MVariance.OUT
	}
