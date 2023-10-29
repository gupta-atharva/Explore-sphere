
# ExploreSphere - Your Ultimate Tour Guide

ExploreSphere is your ultimate tour guide app, where machine learning is seamlessly integrated into a Kotlin-based Android app. 
Key Features
- User Authentication: ExploreSphere uses Firebase Authentication for user registration and login. Your data is securely managed, and the authentication process is streamlined. The advantages of this authentication system are that it is efficient, secure, and doesn't require additional storage space for user data.

- Travel Planning: Users are prompted to input the month of their intended travel, their budget, and describe the destination they wish to visit.

- Destination Recommendations: Based on user input, the app leverages machine learning to recommend the top 3 destinations, complete with detailed descriptions.

# Machine Learning Integration
Due to the unavailability of a suitable dataset, data scraping became essential. Here's how it works:

- Data Scraping: Data was scraped from various sources, as a suitable dataset wasn't readily available.

- Data Processing: The scraped data was processed using libraries such as NumPy, Pandas, NLTK, and Scikit-learn. These libraries excel in natural language processing (NLP) and form the core of our machine learning model.

- Cosine Similarity: To recommend the top 3 places, ExploreSphere employs cosine similarity to find the best-suited destinations based on user input for travel time, budget, and description.

- Link to our hosted flask app: https://atharvagupta.pythonanywhere.com/

Happy exploring!
