import React from 'react'
import { Outlet } from 'react-router-dom'
import AppHeader from '../components/AppHeader'
import AppSidebar from '../components/AppSidebar'
import AppBreadcrumb from '../components/AppBreadcrumb'

const DefaultLayout = () => {
    return (
        <div>
            <AppSidebar />
            <div className="wrapper d-flex flex-column min-vh-100 bg-dark text-white" style={{ marginLeft: '240px' }}>
                <AppHeader />
                <AppBreadcrumb />
                <div className="body flex-grow-1 px-3">
                    <Outlet />
                </div>
            </div>
        </div>
    )
}

export default DefaultLayout
