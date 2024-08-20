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
                "love!"
            )
        ),
        Post(2, R.drawable.bo_luke,
            "Bo and Luke",
            "husky mix",
            "resident troublemakers",
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
            "a philosopher",
            "contemplative sit-downs on walks",
            "german shepard puppy sitting politely on sidewalk"
        ),
        Post(5, R.drawable.winston,
            "Winston",
            "yorkie",
            "old man",
            "all bark no bite!!",
            "little white dog jumping at camera"
        )
    )

    val collection2 = listOf(
        Post(1, R.drawable.allie,
            "allie","border collie",
            "ceramics teacher's child",
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
            "uncle's dog",
            "loved sharing my food with her as a kid",
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

    val cartoons = listOf(
        Post(1, R.drawable.odie,
            "odie","beagle",
            "garfields brother",
            "happy",
            "happy odie"
        ),
        Post(2, R.drawable.scooby,
            "scooby doo",
            "great dane",
            "shaggy's best friend",
            "loves scooby snacks",
            "proud scooby doo"
        ),
        Post(3, R.drawable.snoopy,
            "snoopy",
            "beagle",
            "charlie brown's dog",
            "smart",
            "happy snoopy side-eye"
        )
    )
}