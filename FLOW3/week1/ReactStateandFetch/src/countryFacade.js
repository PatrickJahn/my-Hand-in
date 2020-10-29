import utils from "./utils";


const URL_LABEL = "http://localhost:3333/labels"
const URL_COUTRIES= "http://localhost:3333/countries"
const countryFacade = () => {

  const getLabels = (callback) => {
    utils.fetchAny(URL_LABEL, callback)
  }

  const getCountries = (callback) => {
    utils.fetchAny(URL_COUTRIES, callback)
  
  }
  return {
    getLabels,
    getCountries
  }
}

export default  countryFacade();