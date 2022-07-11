import {Box} from '@mui/material'
import {Outlet} from 'react-router-dom'
import * as React from 'react'
import NavBar from '../components/NavBar'


const MainLayout = () => {
	return (
		<Box sx={{ display: 'flex' }}>
			<NavBar/>
			<div style={{
				margin: '0 auto',
				marginTop: '100px'
			}}>
				<Outlet/>
			</div>
		</Box>
	)
}
export default MainLayout
