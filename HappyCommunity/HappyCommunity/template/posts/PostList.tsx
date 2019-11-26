import React, { Component } from "react";
import { View, Text, ScrollView, StyleSheet } from "react-native";
import { PostOverviewModel } from "models/PostOverviewModel";
import Post from "./Post"
import axios from "axios"

export default class PostList extends Component {
 API: string = "localhost:5000/api";
 posts: PostOverviewModel[] = [
  {id: 1, creator:  "Mikkel", distance: 2, reward: 100, title: "Mega nice"},
  {id: 2, creator:  "Pernille", distance: 10, reward: -100, title: "Mega taber :D"},
  {id: 3, creator:  "Mikkel", distance: 2, reward: 100, title: "Mega nice"},
  {id: 4, creator:  "Pernille", distance: 10, reward: -100, title: "Mega taber :D"},
  {id: 5, creator:  "Mikkel", distance: 2, reward: 100, title: "Mega nice"},
  {id: 6, creator:  "Pernille", distance: 10, reward: -100, title: "Mega taber :D"},
  {id: 7, creator:  "Mikkel", distance: 2, reward: 100, title: "Mega nice"},
  {id: 8, creator:  "Pernille", distance: 10, reward: -100, title: "Mega taber :D"},
  {id: 9, creator:  "Mikkel", distance: 2, reward: 100, title: "Mega nice"},
  {id: 10, creator:  "Pernille", distance: 10, reward: -100, title: "Mega taber :D"},
  {id: 11, creator:  "Mikkel", distance: 2, reward: 100, title: "Mega nice"},
  {id: 12, creator:  "Pernille", distance: 10, reward: -100, title: "Mega taber :D"},
  {id: 13, creator:  "Mikkel", distance: 2, reward: 100, title: "Mega nice"},
  {id: 14, creator:  "Pernille", distance: 10, reward: -100, title: "Mega taber :D"},
  {id: 15, creator:  "Mikkel", distance: 2, reward: 100, title: "Mega nice"},
  {id: 16, creator:  "Pernille", distance: 10, reward: -100, title: "Mega taber :D"},
  {id: 17, creator:  "Mikkel", distance: 2, reward: 100, title: "Mega nice"},
  {id: 18, creator:  "Pernille", distance: 10, reward: -100, title: "Mega taber :D"}
];
  componentWillMount() {
    axios.get(this.API + '/getPosts/')
        .then(response => {
            this.posts = response.data;
            // this.setState({ postsSet });
        })
  }
  navigateToPost(id: Number) {

  }
  render() {
    return (
      <View style={styles.body}>
        {this.posts.map( (post, i) => {
           return (
            <View style={{marginVertical: 10}} >
              <Post
                key={i}
                id={post.id}
                title={post.title}
                creator={post.creator}
                reward={post.reward}
                distance={post.distance} />
            </View>
          );
        })}
      </View>
    );
  }
}

const styles = StyleSheet.create({
  body: {
    display: 'flex'
  }
})