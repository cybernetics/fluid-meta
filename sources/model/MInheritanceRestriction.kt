package io.fluidsonic.meta

import kotlinx.metadata.*


enum class MInheritanceRestriction {

	ABSTRACT,
	FINAL,
	OPEN;


	override fun toString() =
		MetaCodeWriter.write(this)


	companion object {

		internal fun forFlags(flags: Flags) =
			when {
				Flag.IS_ABSTRACT(flags) -> ABSTRACT
				Flag.IS_FINAL(flags) -> FINAL
				Flag.IS_OPEN(flags) -> OPEN
				Flag.IS_SEALED(flags) -> ABSTRACT
				else -> throw MetaException("unknown inheritance restriction in flags ${flags.toString(16)}")
			}
	}
}
