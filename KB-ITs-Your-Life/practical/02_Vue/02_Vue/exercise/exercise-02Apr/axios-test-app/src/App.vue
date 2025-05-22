<template></template>
<script setup>
import axios from 'axios';

const runTests = async () => {
  const getById = await axios.get('/api/todos/1');
  console.log('id가 1인 todo:', getById.data);
};

runTests();

const requestAPI = () => {
  let todoList = [];
  axios
    .get('/api/todos')
    .then((response) => {
      todoList = response.data;
      console.log('# TodoList :', todoList);
      return todoList[0].id;
    })
    .then((id) => axios.get('/api/todos/' + id))
    .then((response) => {
      console.log('## id가 1인 Todo: ', response.data);
    });
};

requestAPI();
</script>
