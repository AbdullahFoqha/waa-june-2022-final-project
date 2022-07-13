import {Autocomplete, Button, Grid, TextField} from '@mui/material'
import ReactDataTable from './common/DataTable'
import {useEffect, useState} from 'react'
import useRole from '../config/security/hooks/useRole'
import RenderIf from './common/RenderIf'
import {applyJobAdvertisement, getCities, getJobs, getStates, getTags} from '../services/job'
import {useKeycloak} from '@react-keycloak/web'
import {useFormik} from 'formik'


const tags = []
const states = []
const cities = []
const JobsAdvertisements = () => {
	const {
		keycloak: {
			tokenParsed: { sub: studentId }
		}
	} = useKeycloak()
	const [lstJobs, setJobs] = useState([])
	const { isStudent } = useRole()
	const [tagState, setTagState] = useState()
	const [stateState, setStateState] = useState()
	const [cityState, setCityState] = useState()

	const fetchJobsData = async (searchParams) => {
		console.log(searchParams)
		const { data } = await getJobs(searchParams)

		setJobs(data)
	}

	const Apply = async (data) => {
		await applyJobAdvertisement(data)
	}

	const columns = [{
		name: 'Tag', selector: (row) => row.tag.name
	}, {
		name: 'companyName', selector: (row) => row.companyName
	}, {
		name: 'state', selector: (row) => row.state.name
	}, {
		name: 'city', selector: (row) => row.city.name
	}, {
		name: 'description', selector: (row) => row.description
	}, {
		name: 'benefits', selector: (row) => row.benefits
	}, {
		selector: (row) => (
			<RenderIf condition={isStudent}>
				<Button onClick={() => Apply({ userId: studentId, job: row })}>
					Apply
				</Button>
			</RenderIf>
		)
	}]

	const init = async () => {
		const { data: tagsData } = await getTags()
		tagsData.map((x) => tags.push({ label: x.name, id: x.id }))
		setTagState(tags)
		const { data: statesData } = await getStates()
		statesData.map((x) => states.push({ label: x.name, id: x.id }))
		setStateState(states)
		const { data: citiesData } = await getCities()
		citiesData.map((x) => cities.push({ label: x.name, id: x.id }))
		setCityState(cities)
	}

	useEffect(() => {
		fetchJobsData({})
		init()
	}, [])

	const { errors, touched, handleSubmit, values, handleChange, setFieldValue } = useFormik({
		initialValues: {
			tag: '', state: '', city: '', companyName: '', description: '', benefits: '', file: ''
		}, onSubmit: async (values) => {
			values.tag = { ...tagState }
			values.state = { ...stateState }
			values.city = { ...cityState }
			await fetchJobsData(values)
		}
	})
	return (
		<>
			<div style={{ border: '1px solid #e4e4e4', padding: '1rem', borderRadius: '.8rem' }}>
				<form onSubmit={handleSubmit}>
					<Grid container direction={'row'} spacing={1} sx={{ alignItems: 'center' }}>
						<Grid item>
							<Autocomplete
								disablePortal
								id="autocomplete-tag"
								options={tags}
								sx={{ width: '20rem' }}
								onChange={(event, value) => {
									setTagState(value)
								}}
								renderInput={(params) => (
									<TextField
										{...params}
										id="tag"
										name="tag"
										label="tag"
										error={touched.tag && Boolean(errors.tag)}
										helperText={touched.tag && errors.tag}
									/>
								)}
							/>
						</Grid>
						<Grid item>
							<Autocomplete
								disablePortal
								id="autocomplete-state"
								options={states}
								sx={{ width: '20rem' }}
								onChange={(event, value) => {
									setStateState(value)
								}}
								renderInput={(params) => (
									<TextField
										{...params}
										id="state"
										name="state"
										label="state"
										error={touched.state && Boolean(errors.state)}
										helperText={touched.state && errors.state}
									/>
								)}
							/>
						</Grid>
						<Grid item>
							<Autocomplete
								disablePortal
								id="autocomplete-city"
								options={cities}
								sx={{ width: '20rem' }}
								onChange={(event, value) => {
									setCityState(value)
								}}
								renderInput={(params) => (
									<TextField
										{...params}
										id="city"
										name="city"
										label="city"
										error={touched.city && Boolean(errors.city)}
										helperText={touched.city && errors.city}
									/>
								)}
							/>
						</Grid>
						<Grid item>
							<TextField
								id="companyName"
								name="companyName"
								label="companyName"
								type="companyName"
								sx={{ width: '20rem' }}
								value={values.companyName}
								onChange={handleChange}
								error={touched.companyName && Boolean(errors.companyName)}
								helperText={touched.companyName && errors.companyName}
							/>
						</Grid>
						<Grid item>
							<Button color="primary" variant="contained" fullWidth type="submit"> Search </Button>
						</Grid>
					</Grid>
				</form>
			</div>
			<Grid container>
				<Grid item md={12} width="50rem">
					<ReactDataTable data={lstJobs} columns={columns}/>
				</Grid>
			</Grid>
		</>
	)
}

export default JobsAdvertisements
