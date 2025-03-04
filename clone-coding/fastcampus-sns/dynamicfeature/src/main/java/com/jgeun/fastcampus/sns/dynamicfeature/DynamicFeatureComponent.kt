package com.jgeun.fastcampus.sns.dynamicfeature

import com.jgeun.fastcampus.sns.app.FooEntryPoint
import dagger.Component

/**
 * @author   JGeun
 * @created  2025/03/01
 */
@Component(dependencies = [FooEntryPoint::class])
interface DynamicFeatureComponent {

	fun inject(target: DynamicFeatureActivity)
}