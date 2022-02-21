import React, {Component} from "react";

import Main from './components/main.jsx';
import TeacherTable from './components/teacher.jsx';
import StudentTable from './components/students.jsx';
import ParentTable from './components/parent.jsx';
import GroupTable from './components/groups.jsx';
import CourseTable from './components/courses.jsx';
import AppLayout from './components/Layouts/AppLayout';
import { BrowserRouter as Router, Route, Routes } from 'react-router-dom'

class App extends Component{
    render() {
        return (
            <Router>
                <Routes>
                    <Route path='/' element={<AppLayout />}>
                        <Route exact path="/" element={<Main/>}/>
                        <Route exact path="/teachers" element={<TeacherTable/>}/>
                        <Route exact path="/students" element={<StudentTable/>}/>
                        <Route exact path="/parents" element={<ParentTable/>}/>
                        <Route exact path="/groups" element={<GroupTable/>}/>
                        <Route exact path="/courses" element={<CourseTable/>}/>
                    </Route>
                </Routes>
            </Router>
        );
    };
}

export default App;
