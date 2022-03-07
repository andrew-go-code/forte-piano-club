package ru.andrewgo.demo.application

import BarEventsHolder
import BarMenuHolder

val barEventsMock = listOf(
    BarEventsHolder(
        year = 2022,
        month = "January",
        events = listOf(
            BarEventsHolder.BarEvent(
                name = "Nemnogo Nervno",
                genre = "Dream folk",
                details = "There could be some details",
                imageSrc = "https://regnum.ru/uploads/pictures/news/2019/08/26/regnum_picture_1566834740338709_normal.jpg"
            ),
            BarEventsHolder.BarEvent(
                name = "Bregan D’Ert",
                genre = "Rock",
                details = "There could be some details",
                imageSrc = "https://newslab.ru/Static/afisha/2019-11-2/Kancler_Gi-237937.jpg"
            ),
            BarEventsHolder.BarEvent(
                name = "Karelia",
                genre = "Folk",
                details = "There could be some details",
                imageSrc = "https://peterburg2.ru/uploads/21/03/26/o_1_19.jpg"
            ),
            BarEventsHolder.BarEvent(
                name = "Karelia",
                genre = "Folk",
                details = "There could be some details",
                imageSrc = "https://peterburg2.ru/uploads/21/03/26/o_1_19.jpg"
            ),
            BarEventsHolder.BarEvent(
                name = "Nemnogo Nervno",
                genre = "Dream folk",
                details = "There could be some details",
                imageSrc = "https://regnum.ru/uploads/pictures/news/2019/08/26/regnum_picture_1566834740338709_normal.jpg"
            ),
            BarEventsHolder.BarEvent(
                name = "Bregan D’Ert",
                genre = "Rock",
                details = "There could be some details",
                imageSrc = "https://newslab.ru/Static/afisha/2019-11-2/Kancler_Gi-237937.jpg"
            ),
        )
    ), BarEventsHolder(
        id = "2",
        year = 2022,
        month = "February",
        events = listOf(
            BarEventsHolder.BarEvent(
                name = "Princess Angine",
                genre = "Indi",
                details = "There could be some details",
                imageSrc = "https://i1.wp.com/www.israelculture.info/wp-content/uploads/2016/03/PA-19.jpg?w=1152&ssl=1"
            )
        )
    )
)

val barMenuMock = listOf(
    BarMenuHolder(
        id = "1",
        category = "Drinks",
        items = listOf(
            BarMenuHolder.BarMenuItem(
                name = "Drink Name 1",
                description = "There could be a description",
                calories = 100,
                imageSrc = "https://media.istockphoto.com/photos/craft-cocktail-assortment-on-well-lit-bar-picture-id502072256?b=1&k=20&m=502072256&s=170667a&w=0&h=lk51ZBUdn8ZnVcGHJNJDqB9yEHq-EHVQR0K3c47IzuI=",
                price = 100
            ),
            BarMenuHolder.BarMenuItem(
                name = "Drink Name 2",
                description = "There could be a description",
                calories = 150,
                imageSrc = "https://images.unsplash.com/photo-1497534446932-c925b458314e?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxzZWFyY2h8MXx8ZHJpbmtzfGVufDB8fDB8fA%3D%3D&w=1000&q=80",
                price = 200
            ),
        )
    ),
    BarMenuHolder(
        id = "2",
        category = "Dessert",
        items = listOf(
            BarMenuHolder.BarMenuItem(
                name = "Dessert Name 1",
                description = "There could be a description",
                calories = 200,
                imageSrc = "https://images-gmi-pmc.edge-generalmills.com/7c1096c7-bfd0-4806-a794-1d3001fe0063.jpg",
                price = 300
            ),
            BarMenuHolder.BarMenuItem(
                name = "Dessert Name 4",
                description = "There could be a description",
                calories = 300,
                imageSrc = "https://img.taste.com.au/xi2t8DpL/taste/2016/11/lemon-panna-cotta-with-vodka-blueberry-syrup-92005-1.jpeg",
                price = 400
            ),
        )
    )
)