import React, { Component } from "react";
import { View, Text, StyleSheet } from "react-native";
import { PostOverviewModel } from "models/PostOverviewModel";

export default class Post extends Component<PostOverviewModel, {}> {


  render() {
    return (
      <View style={{flex: 1, flexDirection: 'row', justifyContent: 'center'}}>
        <View style={{flex: 0.2}}></View>
        <View style={{flex: 0.6, paddingLeft: 10}}>
          <Text style={{justifyContent: 'center'}}>{this.props.title}</Text>
          <Text>{this.props.creator}</Text>
          <Text>{this.props.reward}</Text>
        </View>
        <View style={styles.distance}>
          <Text>Distance:</Text>
          <Text>{this.props.distance}km</Text>
        </View>
      </View>
    );
  }
}

const styles = StyleSheet.create({
  container: {
    justifyContent: 'center'
  },
  distance: {
    flex: 0.2,
    paddingRight: 10,
    justifyContent: 'center'
  }
});