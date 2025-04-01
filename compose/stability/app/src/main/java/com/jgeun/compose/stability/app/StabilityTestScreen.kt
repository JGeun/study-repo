package com.jgeun.compose.stability.app

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import com.jgeun.compose.stability.sub.model.ImmutableModel
import com.jgeun.compose.stability.sub.model.StableMarkerModel
import com.jgeun.compose.stability.sub.model.StableModel
import com.jgeun.compose.stability.sub.model.UnstableModel

/**
 *
 * @author   JGeun
 * @created  2025/04/01
 */
@Composable
fun StabilityTestScreen(
    stableMarkerModel: StableMarkerModel, // stable
    stableModelInApp: StableModelInApp, // stable
    immutableModel: ImmutableModel, // stable
    stableModel: StableModel, // unstable
    unStableModel: UnstableModel // unstable
) {
    Column {
        PersonData(
            stableMarkerModel.name,
            stableMarkerModel.age
        )
        PersonData(
            stableModelInApp.name,
            stableModelInApp.age
        )
        PersonData(
            immutableModel.name,
            immutableModel.age
        )
        PersonData(
            stableModel.name,
            stableModel.age
        )
        PersonData(
            unStableModel.name,
            unStableModel.age
        )
    }
}

@Composable
private fun PersonData(
    name: String,
    age: Int
) {
    Text("Name: $name, Age: $age")
}