import React, { Component } from "react";
import { View, Text } from "react-native";

export default class Post extends Component {

  render() {
    return (
      <View>
        <View>
          {/* Picture of post */}
        </View>
        <View>
          <Text>Post title</Text>
          <Text>Username</Text>
          <Text>Reward</Text>
        </View>
        <View>
          <Text>Distance</Text>
        </View>
      </View>
    );
  }
}