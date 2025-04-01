package com.jgeun.compose.stability.app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import com.jgeun.compose.stability.sub.model.ImmutableModel
import com.jgeun.compose.stability.sub.model.StableMarkerModel
import com.jgeun.compose.stability.sub.model.StableModel
import com.jgeun.compose.stability.sub.model.UnstableModel

/**
 *
 * @author   JGeun
 * @created  2025/04/01
 */
class StabilityTestActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            Surface {
                Scaffold(
                    content = { padding ->
                       Box(
                           modifier = Modifier.fillMaxSize()
                               .padding(padding)
                       ) {
                           StabilityTestScreen(
                               StableMarkerModel(
                                   name = "StableMarkerModel",
                                   age = 1
                               ),
                               StableModelInApp(
                                  name = "StableModelInApp",
                                  age = 1
                               ),
                               ImmutableModel(
                                   name = "ImmutableModel",
                                   age = 1
                               ),
                               StableModel(
                                   name = "Stability",
                                   age = 1
                               ),
                               UnstableModel(
                                  name = "UnStability",
                                  age = 2
                               )
                           )
                       }
                    }
                )
            }
        }
    }
}