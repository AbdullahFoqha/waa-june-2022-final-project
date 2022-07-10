import logo from './logo.svg'
import './App.css'
import {useKeycloak} from '@react-keycloak/web'
import RenderIf from './components/common/RenderIf'


function App() {
	const { keycloak, initialized } = useKeycloak()

	return (<div className="App">
		<header className="App-header">
			<img src={logo} className="App-logo" alt="logo"/>

			<RenderIf condition={!keycloak.authenticated}>
				<button onClick={() => keycloak.login()}>
					Login
				</button>
			</RenderIf>

			<RenderIf condition={keycloak.authenticated}>
				<button onClick={() => keycloak.logout()}>
					Logout
				</button>
			</RenderIf>

			<RenderIf condition={keycloak.authenticated}>
				<div>
					{keycloak.token}
				</div>
			</RenderIf>
		</header>
	</div>)

}

export default App
