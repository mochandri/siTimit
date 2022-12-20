<?php
defined('BASEPATH') OR exit('No direct script access allowed');
class Mahasiswa extends CI_Controller {
function __construct(){
parent::__construct();

}
public function index(){
    $this->load->model('Mahasiswa_model');
    $data['Mahasiswa'] = $this->Mahasiswa_model->get_data();
    $this->load->view('view_mahasiswa',$data);
}
// public function index(){
//     $this->load->model('prodi_model');
//     $data['Prodi'] = $this->prodi_model->get_data();
//     $this->load->view('view_prodi',$data);
// }
// public function angkatan(){
//     $this->load->model('angkatan_model');
//     $data['Angkatan'] = $this->angkatan_model->get_data();
//     $this->load->view('view_angkatan',$data);
// }
}
