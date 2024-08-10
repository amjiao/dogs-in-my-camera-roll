package com.example.jetpack

import androidx.compose.ui.res.painterResource

object PostRepo{
    val postList = listOf(
        Post(1, R.drawable.benny,
            "benny","doodle",
            "resident of natalie's second chance",
            "so so happy",
            "dog with black curly fur smiling from the left side of the frame",
            mutableListOf(
                "so cute!",
                "awww",
                "love love love!",
                "omg"
            )
        ),
        Post(2, R.drawable.bo_luke,
            "Bo and Luke",
            "husky mix",
            "natalie's second chance resident troublemakers",
            "adopted :')",
            "two brown husky puppies in the parking lot",
            mutableListOf("cute")
        ),
        Post(3, R.drawable.cleatus,
            "Cleatus",
            "husky mix",
            "part of the luke and bo trio",
            "resident stinky man",
            "side profile of dark grey husky puppy sticking tongue out"
        ),
        Post(4, R.drawable.trixie,
            "Trixie",
            "german shepard mix",
            "natalie's philosopher",
            "takes contemplative breaks on walks",
            "german shepard puppy sitting politely on sidewalk"
        ),
        Post(5, R.drawable.winston,
            "Winston",
            "yorkie",
            "natalie's old man",
            "all bark no bite!!",
            "little white dog jumping at camera"
        )
    )

    val collection2 = listOf(
        Post(1, R.drawable.allie,
            "allie","border collie",
            "my ceramics teacher's child",
            "really good at begging for goldfish",
            "black border collie doing puppy eyes",
            mutableListOf(
                "GIVE HER ALL THE GOLDFISH"
            )
        ),
        Post(2, R.drawable.anonymous_doodle,
            "anonymous doodle",
            "golden doodle",
            "therapy dog at cornell",
            "",
            "smiling golden doodle on a table",
            mutableListOf("cute")
        ),
        Post(3, R.drawable.awang,
            "awang",
            "unknown",
            "my uncles dog in china",
            "12 year old me got in trouble for sharing too much of my food with her",
            "white dog squinting in sun"
        ),
        Post(4, R.drawable.reindeer,
            "reindeer",
            "reindeer, obviously",
            "saw on a street in japan",
            "",
            "golden retriever with reindeer antlers laying in the street"
        )
    )
}