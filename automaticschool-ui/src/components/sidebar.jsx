import React from 'react';
import {
    CDBSidebar,
    CDBSidebarContent,
    CDBSidebarFooter,
    CDBSidebarHeader,
    CDBSidebarMenu,
    CDBSidebarMenuItem,
} from 'cdbreact';
import { NavLink } from 'react-router-dom';

const Sidebar = () => {
    return (
        <div style={{ display: 'flex', height: '100vh', overflow: 'scroll initial' }}>
            <CDBSidebar textColor="#fff" backgroundColor="#333">
                <CDBSidebarHeader prefix={<i className="fa fa-bars fa-large"></i>}>
                    <a href="/" className="text-decoration-none" style={{ color: 'inherit' }}>
                        Automatic School
                    </a>
                </CDBSidebarHeader>
                <CDBSidebarContent className="sidebar-content">
                    <CDBSidebarMenu>
                        <NavLink exact to="/" activeClassName="activeClicked">
                            <CDBSidebarMenuItem icon="columns">Dashboard</CDBSidebarMenuItem>
                        </NavLink>
                        <NavLink exact to="/teachers" activeClassName="activeClicked">
                            <CDBSidebarMenuItem icon="user">Teachers</CDBSidebarMenuItem>
                        </NavLink>
                        <NavLink exact to="/students" activeClassName="activeClicked">
                            <CDBSidebarMenuItem icon="user">Students</CDBSidebarMenuItem>
                        </NavLink>
                        <NavLink exact to="/parents" activeClassName="activeClicked">
                            <CDBSidebarMenuItem icon="user">Parents</CDBSidebarMenuItem>
                        </NavLink>
                        <NavLink exact to="/groups" activeClassName="activeClicked">
                            <CDBSidebarMenuItem icon="user">Groups</CDBSidebarMenuItem>
                        </NavLink>
                        <NavLink exact to="/courses" activeClassName="activeClicked">
                            <CDBSidebarMenuItem icon="user">Courses</CDBSidebarMenuItem>
                        </NavLink>
                    </CDBSidebarMenu>
                </CDBSidebarContent>
                <CDBSidebarFooter>
                    <div>
                        <CDBSidebarMenuItem icon="cogs">Settings</CDBSidebarMenuItem>
                    </div>
                </CDBSidebarFooter>
            </CDBSidebar>
        </div>
    );
};
export default Sidebar;