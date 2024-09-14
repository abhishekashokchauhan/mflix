# mflix - Java Backend project focused on the MongoDB interactions
- Created the spring boot project with Atlas
- Playing with 2 collections in the same database, "comments" , "movies"
- Getting the comments for a perticular movie name
- Getting the movieId for a movie title.
- Using this movieId to get all the comments.
- Revised pagination in MongoDB
- Revised how to get selected fields from the document !
- Add the comment to a "comments" collection using the backend.

# Attaching the sampele request here.
- http://localhost:8080/comments?title=It
- http://localhost:8080/movies?page=1&size=1
- http://localhost:8080/movies?page=1&size=1&sortBy=year
- curl --location 'http://localhost:8080/comments?title=Inception' --header 'Content-Type: application/json' --data '{"text": "Abhishek is trying and learnign new things"}'

# Pending items
- Explore mongoTempalte for Aggregations.
