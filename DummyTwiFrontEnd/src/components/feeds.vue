<template>
<div class = "hello">
  <div>
     <div>Post id:: {{feeds.id}}</div>
     <div>Post Content:: {{feeds.post}}</div>
  </div>
  <div>
    <button v-on:click="handleDelete()" class="btn-cls">Delete</button>
  </div>
  </div>
</template>

<script>
export default {
  name: 'HelloWorld',
  props: {
    feeds: Object
  },
  methods: {
    handleDelete() {
      console.log("Deleting id:: ",this.feeds.id);
      this.$emit("delete_tweet",this.feeds.id);
    }
  }

}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
.btn-cls {
  width: 50px;
  height: 20px;
  margin-bottom: 50px;
}
.hello {
  border: 1px solid black;
}
h3 {
  margin: 40px 0 0;
}
ul {
  list-style-type: none;
  padding: 0;
}
li {
  display: inline-block;
  margin: 0 10px;
}
a {
  color: #42b983;
}
</style>
