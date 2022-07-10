import {Box, AppBar, Toolbar, Button, Typography} from '@mui/material'
import {Outlet} from 'react-router-dom'
import {useKeycloak} from '@react-keycloak/web'


const MainLayout = (props) => {
	const { keycloak: { login } } = useKeycloak()

	return (
		<Box sx={{ display: 'flex' }}>
			<AppBar>
				<Toolbar>
					<Typography
						variant="h6"
						noWrap
						component="a"
						href="/"
						sx={{
							mr: 2,
							display: { xs: 'none', md: 'flex' },
							fontFamily: 'monospace',
							fontWeight: 700,
							letterSpacing: '.3rem',
							color: 'inherit',
							textDecoration: 'none'
						}}
					>
						LOGO
					</Typography>
					<Typography
						variant="h6"
						component="a"
						href="/"
						sx={{ flexGrow: 1, color: 'inherit', textDecoration: 'none' }}
					>
						Students
					</Typography>
					<Button color="inherit" onClick={() => login()}>Login</Button>
				</Toolbar>
			</AppBar>
			<div style={{ margin: '0 auto', marginTop: '100px' }}>
				<Outlet/>
			</div>
		</Box>
	)
}

export default MainLayout
