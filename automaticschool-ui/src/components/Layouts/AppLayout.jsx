import { Outlet } from "react-router-dom";
import Sidebar from '../sidebar.jsx';

const AppLayout = () => {
    return <div style={{display:"flex"}}>
        <Sidebar />
        <Outlet />
    </div>;
};

export default AppLayout;