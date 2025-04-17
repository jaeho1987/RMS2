import React, { useEffect, useState } from 'react'
import {
    CSidebar,
    CSidebarNav,
    CNavItem,
    CNavGroup,
    CSidebarHeader,
    CSidebarBrand,
} from '@coreui/react'
import axios from 'axios'

const AppSidebar = () => {
    const [menus, setMenus] = useState([])

    useEffect(() => {
        axios
            .get('/api/menus', {
                withCredentials: true,
                headers: { 'X-Requested-With': 'XMLHttpRequest' },
            })
            .then((res) => {
                if (typeof res.data === 'string' && res.data.includes('<html')) {
                    window.location.href = '/login'
                } else {
                    setMenus(buildMenuTree(res.data))
                }
            })
            .catch((err) => {
                if (err.response?.status === 401) window.location.href = '/login'
            })
    }, [])

    const buildMenuTree = (list) => {
        const map = {}, roots = []
        list.forEach((item) => (map[item.menuId] = { ...item, children: [] }))
        list.forEach((item) => {
            item.parentId
                ? map[item.parentId]?.children.push(map[item.menuId])
                : roots.push(map[item.menuId])
        })
        return roots
    }

    const renderMenu = (items) =>
        items.map((item) =>
            item.children?.length ? (
                <CNavGroup key={item.menuId} toggler={item.menuName}>
                    {renderMenu(item.children)}
                </CNavGroup>
            ) : (
                <CNavItem key={item.menuId} href={item.menuPath}>
                    {item.menuName}
                </CNavItem>
            )
        )

    return (
        <CSidebar unfoldable className="bg-dark text-white" visible>
            <CSidebarHeader>
                <CSidebarBrand>RMS</CSidebarBrand>
            </CSidebarHeader>
            <CSidebarNav>{renderMenu(menus)}</CSidebarNav>
        </CSidebar>
    )
}

export default AppSidebar
