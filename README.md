## Project Documentation: Megaventory Integration

### Overview

This project utilizes the OpenAI GPT model through the recently released Spring AI project to generate poetry using the exposed HTTP endpoints.

### How to Use
**To run the project:** Run `docker compose up` from your command line (docker engine and docker compose are needed).

1. **To generate a robot haiku:**
   - Send a `GET` request to `localhost:8080/robotHaiku`
   - Sample response:  
Robot in the night,  
Metal heart beats with the stars,  
Automation's might.

2. **To generate a poem using the given genre and theme:**
   - Send a `GET` request to `localhost:8080/poetry?genre={genre}&theme={theme}`
   - Sample response from `localhost:8080/poetry?genre=romantic&theme=food`:
```json
{
    "title": "Flavors of Love",
    "poetry": "In the realm of flavors and delight,\nA feast for our senses, day or night.\nLove is the secret ingredient, my dear,\nAs we savor the taste, together we cheer.\n\nA delicate dance of aroma and taste,\nFood becomes art, a masterpiece embraced.\nWith every bite, our hearts intertwine,\nCreating a symphony, a love so divine.\n\nFrom the sweetness of chocolate, passion ignites,\nMelting like butter, our souls take flight.\nWhispering spices, like a gentle caress,\nFood becomes poetry, as love we express.\n\nA table for two, adorned with desire,\nCandles flicker, flames reaching higher.\nEating with passion, our souls intertwine,\nFood becomes love, a feeling so fine.\n\nSo let us indulge, in this romantic cuisine,\nWhere love and food, forever convene.\nFor in each bite, our hearts intertwine,\nA love story written, through flavors divine.",
    "genre": "Romantic",
    "theme": "Food and Love"
}
```