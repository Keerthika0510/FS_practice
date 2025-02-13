const express = requuire('express');
const mongoose = require('mongoose');
const bodyParser = require('body-parser');
const cors = require('cors');
require('dotenv').config();
const app = express();
app.use('bodyParser');
app.use('cors');
mongoose.connect(process.env.MONGO_URI,
    {
        useNewbodyParser:true,
        useUnifiedTopology:true,
    })
    .then(()=>console.log('connected to mongodb'))
    .catch((err)=>console.log('failed connection',err));
    //Task Model
    const taskSchema = new mongoose.Schema({
      title: { type: String, required: true },
      description: { type: String, required: true },
      status: {
        type: String,
        enum: ['Pending', 'In Progress', 'Completed'],
        default: 'Pending',
      },
      dueDate: { type: Date, required: true },
    });
    const Task=mongoose.model('Task',taskSchema);
    const taskRoutes=express().Router;
    //get all tasks
    taskRoutes.get('/',async(req,res)=>{
        try{
            const tasks = await Task.find();
            res.status(200).json(tasks);
        }catch(error){
            res.status(500).json({message:'cannot fetch tasks',error:error.message});
        }
    });
    //get task by  id
    taskRoutes.get('/:id',async(req,res)=>{
        try{
            const task = await Task.findById(req.params.id);
            if(!task)
            {
                return res.status(400).json({message:'task not found'});
            }
            res.status(200).json(task);
        }catch(error){
            res.status(500).json({message:'cannot fetch tasks',error:error.message});
        }
    });
    //create a new task
    taskRoutes.post('/',async(req,res)=>{
        try{
            const task = new Task.find(req.body);
            const savedTask=await task.save();
            res.status(201).json(savedTask);
        }catch(error){
            res.status(400).json({message:'cannot create tasks',error:error.message});
        }
    });
    //update a task
    taskRoutes.put('/:id',async(req,res)=>{
        try{
            const updatedTask = await Task.findByIdAndUpdate(req.params.id,req.body,{new:true});
            if(!updatedTask)
            {
                return res.status(404).json({message:'Task not found'});
            }
            res.status(200).json(updatedTask);
        }catch(error){
            res.status(400).json({message:'cannot update tasks',error:error.message});
        }
    });
    //delete a task
    taskRoutes.delete('/:id',async(req,res)=>{
        try{
            const deletedTask = await Task.findByIdAndDelete(req.params.id);
            if(!deletedTask)
            {
                return res.status(404).json({message:'Task not found'});
            }
            res.status(200).json(deletedTask);
        }catch(error){
            res.status(500).json({message:'cannot delete tasks',error:error.message});
        }
    });
    app.use('/api/tasks',taskRoutes);
    const PORT= process.env.PORT || 5000;
    app.listen(PORT,()=>console.log(`server running on http://localhost:${PORT}`));

