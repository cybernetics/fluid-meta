package io.fluidsonic.meta

import kotlinx.metadata.*


@Suppress("EqualsOrHashCode")
data class MAnnotation(
	val arguments: Map<MVariableName, MAnnotationArgument<*>>,
	val className: MQualifiedTypeName
) {

	internal constructor(annotation: KmAnnotation) : this(
		arguments = annotation.arguments.entries
			.associateBy({ MVariableName(it.key) }) { MAnnotationArgument(it.value) },
		className = MQualifiedTypeName.fromKotlinInternal(annotation.className)
	)


	override fun hashCode() =
		className.hashCode()


	override fun toString() =
		MetaCodeWriter.write(this)


	companion object
}
