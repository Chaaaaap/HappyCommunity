import React, { Component } from "react";
import {
    View,
    Text,
    KeyboardAvoidingView,
    ScrollView,
    StyleSheet
  } from "react-native";
export default class Login extends Component {
  render() {
    return (
        <KeyboardAvoidingView style={styles.wrapper} behavior="padding">
        <View style={styles.scrollViewWrapper}>
          <ScrollView style={styles.scrollView}>
            <Text style={styles.loginHeader}>Login</Text>
          </ScrollView>
         </View>
       </KeyboardAvoidingView>
    );
  }
}
const styles = StyleSheet.create({
    wrapper: {
      display: "flex",
      flex: 1,

    },
    scrollViewWrapper: {
      marginTop: 70,
      flex: 1
    },
    avoidView: {
      paddingLeft: 30,
      paddingRight: 30,
      paddingTop: 20,
      flex:1
     },
    loginHeader: {
      fontSize: 28,
      fontWeight: "300",
      marginBottom: 40
    }
  });
