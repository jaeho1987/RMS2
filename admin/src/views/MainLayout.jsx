import React, { useState } from 'react';
import { Routes, Route } from 'react-router-dom';
import TopBarCoreUI from '../components/TopBarCoreUI';
import DynamicMenu from '../components/DynamicMenu';
import Breadcrumbs from '../components/Breadcrumbs';

import ReqList from './Requirement/ReqList';
import UserList from './System/UserList';
import UserForm from './System/UserForm';
import AuthManage from './System/AuthManage';
import TraceMatrix from './Requirement/TraceMatrix';

function MainLayout() {
    const userName = "admin";
    const [sidebarVisible, setSidebarVisible] = useState(true);

    const handleLogout = () => {
        window.location.href = "/logout";
    };

    const handleToggleSidebar = () => {
        setSidebarVisible(!sidebarVisible);
    };

    return (
        <>
            <DynamicMenu visible={sidebarVisible} />

            <div
                className="main-content"
                style={{
                    marginLeft: sidebarVisible ? "240px" : "0px",
                    transition: "margin-left 0.3s ease",
                    backgroundColor: "#1d222b",  // 다크 배경
                    color: "#ffffff",            // 텍스트
                    minHeight: "100vh"
                }}

            >
                <TopBarCoreUI
                    userName={userName}
                    onLogout={handleLogout}
                    onToggleSidebar={handleToggleSidebar}
                />
                <Breadcrumbs />
                <div className="p-4">
                    <Routes>
                        <Route path="/req/list" element={<ReqList />} />
                        <Route path="/system/users" element={<UserList />} />
                        <Route path="/system/userform" element={<UserForm />} />
                        <Route path="/system/auth" element={<AuthManage />} />
                        <Route path="/req/matrix" element={<TraceMatrix />} />
                    </Routes>
                </div>
            </div>
        </>
    );
}

export default MainLayout;
