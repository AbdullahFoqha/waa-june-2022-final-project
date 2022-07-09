import logo from './logo.svg'
import './App.css'
import {useKeycloak} from '@react-keycloak/web'


function App() {

	const { keycloak, initialized } = useKeycloak()

	return (<div className="App">
		<header className="App-header">
			<img src={logo} className="App-logo" alt="logo"/>
			{!keycloak.authenticated && <button onClick={() => keycloak.login()}>
				Login
			</button>}
			{keycloak.authenticated && <button onClick={() => keycloak.logout()}>
				Logout
			</button>}
		</header>
	</div>)

}

export default App
