<template>
<div>
  <div class="home">
     <textarea placeholder="Type/Enter something to post..." v-model="content" rows="10" cols="50"></textarea>
  </div>
  <div>
    <button v-on:click="clickHandler" class="btn-cls">Post</button>
  </div>
  <div v-for="(feed,index) in feedArr" v-bind:key=index>
    <Feed v-bind:key=index v-on:delete_tweet="handleDeleteEvent" :feeds="feed"/>
  </div>
  </div>
</template>

<script>
// @ is an alias to /src

import axios from "axios";
import Feed from "../components/feeds.vue";
export default {
  name: 'Home',
  data() {
    return {
      content: "",
      url: "http://localhost:8080/tweet",
      feedArr: []
    }
  },
  methods: {
    clickHandler() {
      axios.post(this.url,{"post":this.content}).then((resp)=>{console.log(resp);
      if(resp.status == 201) {
        this.content = "";
        this.refreshFeed();
      }
      });
    },
    refreshFeed() {
      axios.get(this.url).then((resp)=>{
      console.log("Response:: ",resp);
      let tweetArr = resp?.data?._embedded?.tweet;
      this.feedArr = tweetArr.map((element,ind) => {
        element.id = ind+1;
        return element;        
      });
    });
    },
    getDeleteURLById(id) {
      return this.feedArr[id-1]._links.tweets.href;
    },
    handleDeleteEvent(id) {
      let delURL = this.getDeleteURLById(id);
      console.log("Delete URL:: ",delURL);
      axios.delete(delURL).then((resp)=>{
        console.log("Deletion resp:: ",resp);
        this.refreshFeed();
      })
    }
  },
  components: {
    Feed
  },
  created() {
    this.refreshFeed();
  }
}
</script>
<style scoped>
.btn-cls {
  width: 50px;
  height: 20px;
  margin-bottom: 50px;
}
</style>